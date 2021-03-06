import random
import pygame

s_width = 800
s_height = 700
play_width = 300
play_height = 600
block_size = 30

top_left_x = (s_width - play_width) // 2
top_left_y = s_height - play_height


S = [['.....',
      '.....',
      '..00.',
      '.00..',
      '.....'],
     ['.....',
      '..0..',
      '..00.',
      '...0.',
      '.....']]

Z = [['.....',
      '.....',
      '.00..',
      '..00.',
      '.....'],
     ['.....',
      '..0..',
      '.00..',
      '.0...',
      '.....']]

I = [['..0..',
      '..0..',
      '..0..',
      '..0..',
      '.....'],
     ['.....',
      '.....',
      '0000.',
      '.....',
      '.....']]

O = [['.....',
      '.00..',
      '.00..',
      '.....',
      '.....'],
     ['.....',
      '.00..',
      '.00..',
      '.....',
      '.....']]

J = [['.....',
      '..0..',
      '..0..',
      '.00..',
      '.....'],
     ['.....',
      '.0...',
      '.000.',
      '.....',
      '.....']]

L = [['.....',
      '..0..',
      '..0..',
      '..00.',
      '.....'],
     ['.....',
      '...0.',
      '.000.',
      '.....',
      '.....']]

T = [['.....',
      '..0..',
      '.000.',
      '.....',
      '.....'],
     ['..0..',
      '..00.',
      '..0..',
      '.....',
      '.....'],
     ['.....',
      '.....',
      '.000.',
      '..0..',
      '.....'],
     ['..0..',
      '.00..',
      '..0..',
      '.....',
      '.....']]


shapes = [S, Z, I, O, J, L, T]
shapes_colors = [(0, 255, 0),
                 (255, 0, 0),
                 (0, 255, 255),
                 (255, 255, 0),
                 (255, 165, 0),
                 (0, 0, 255),
                 (128, 0, 128)]


class Piece(object):
    def __init__(self, x, y, shape):
        self.x = x
        self.y = y
        self.shape = shape
        self.color = shapes_colors[shapes.index(shape)]
        self.rotation = 0


def create_grid(locked_pos = {}):
    grid = [[(0, 0, 0) for _ in range(10)] for _ in range(20)]

    for y in range(len(grid)):
        for x in range(len(grid[y])):
            if (x, y) in locked_pos:
                c = locked_pos[(x, y)]
                grid[y][x] = c

    return grid


def clear_rows(grid, locked):
    inc = 0
    for i in range(len(grid) - 1, -1, -1):
        row = grid[i]
        if (0, 0, 0) not in row:
            inc += 1
            ind = i
            for j in range(len(row)):
                try:
                    del locked[(j, i)]
                except:
                    continue

    if inc > 0:
        for key in sorted(list(locked), key=lambda x: x[1])[::-1]:
            x, y = key
            if y < ind:
                newKey = (x, y + inc)
                locked[newKey] = locked.pop(key)




def get_shape():
    return Piece(5, 0, random.choice(shapes))


def draw_grid(surface, grid):
    sx = top_left_x
    sy = top_left_y

    for y in range(len(grid)):
        pygame.draw.line(surface,
                         (128, 128, 128),
                         (sx, sy + y * block_size),
                         (sx + play_width, sy + y * block_size ))
        for x in range(len(grid[y])):
            pygame.draw.line(surface,
                             (128, 128, 128),
                             (sx + x * block_size, sy),
                             (sx + x * block_size, sy + play_height))


def draw_window(surface, grid):
    surface.fill((0, 0, 0))

    pygame.font.init()
    font = pygame.font.SysFont('comicsans', 60)
    label = font.render('Tetris', 1, (255, 255, 255))

    surface.blit(label,
                 (top_left_x + play_width / 2 - (label.get_width() / 2),
                  30))

    for y in range(len(grid)):
        for x in range(len(grid[y])):
            pygame.draw.rect(surface,
                             grid[y][x],
                             (top_left_x + x * block_size,
                              top_left_y + y * block_size,
                              block_size,
                              block_size),
                             0)

    pygame.draw.rect(surface,
                     (255, 0, 0),
                     (top_left_x, top_left_y, play_width, play_height),
                     5)

    draw_grid(surface, grid)
    pygame.display.update()


def convert_shape_format(piece):
    positions = []
    format = piece.shape[piece.rotation % len(piece.shape)]

    for i, line in enumerate(format):
        row = list(line)
        for j, col in enumerate(row):
            if col == '0':
                positions.append((piece.x + j, piece.y + i))

    for i, pos in enumerate(positions):
        positions[i] = (pos[0] - 2, pos[1] - 4)

    return positions


def valid_space(shape, grid):
    accepted_pos = [[(j, i) for j in range(10) if grid[i][j] == (0, 0, 0)] for i in range(20)]
    accepted_pos = [j for sub in accepted_pos for j in sub]

    formatted = convert_shape_format(shape)

    for pos in formatted:
        if pos not in accepted_pos:
            if pos[1] > -1:
                return False

    return True


def check_lost(positions):
    for pos in positions:
        x, y = pos
        if y < 1:
            return True
    return False


def main(win):
    locked_pos = {}
    change_piece = False
    run = True
    current_piece = get_shape()
    next_piece = get_shape()
    clock = pygame.time.Clock()
    fall_time = 0
    fall_speed = 0.27

    while run:
        grid = create_grid(locked_pos)
        fall_time += clock.get_rawtime()
        clock.tick(20)
        if fall_time / 1000 > fall_speed:
            fall_time = 0
            current_piece.y += 1
            if not valid_space(current_piece, grid) and current_piece.y > 0:
                current_piece.y -= 1
                change_piece = True

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False

            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_LEFT:
                    current_piece.x -= 1
                    if not (valid_space(current_piece, grid)):
                        current_piece.x += 1

                if event.key == pygame.K_RIGHT:
                    current_piece.x += 1
                    if not (valid_space(current_piece, grid)):
                        current_piece.x -= 1

                if event.key == pygame.K_DOWN:
                    current_piece.y += 1
                    if not (valid_space(current_piece, grid)):
                        current_piece.y -= 1

                if event.key == pygame.K_UP:
                    current_piece.rotation += 1
                    if not valid_space(current_piece, grid):
                        current_piece.rotation -= 1

        shape_pos = convert_shape_format(current_piece)

        for i in range(len(shape_pos)):
            x, y = shape_pos[i]
            if y > -1:
                grid[y][x] = current_piece.color

        if change_piece:
            for pos in shape_pos:
                p = (pos[0], pos[1])
                locked_pos[p] = current_piece.color
            current_piece = next_piece
            next_piece = get_shape()
            change_piece = False
            clear_rows(grid, locked_pos)

        if check_lost(locked_pos):
            run = False

        draw_window(win, grid)


def main_menu(win):
    main(win)


win = pygame.display.set_mode((s_width, s_height))
pygame.display.set_caption("Tetris")
main_menu(win)
