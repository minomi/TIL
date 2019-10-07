def reconstruction_queue(people):
    sorted_people = sorted(people, key=lambda x : (-x[0], x[1]))
    res = [];
    for p in sorted_people:
        res.insert(p[1], p)
    return res;
