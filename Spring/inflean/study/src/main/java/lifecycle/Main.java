package lifecycle;

import lifecycle.dto.Book;
import lifecycle.dto.Member;
import lifecycle.service.BookRegisterService;
import lifecycle.service.BookSearchService;
import lifecycle.service.MemberRegisterService;
import lifecycle.service.MemberSearchService;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 10. 13..
 */
public class Main {
    public static void main(String[] args) {
        String[] bookIds = {"bookID1", "bookID2", "bookID3", "bookID4"};
        String[] bookTitles = {"bookTitle1", "bookTitle2", "bookTitle3", "bookTitle4"};

        String[] memberIds = {"memberId1", "memberId2", "memberId3"};
        String[] memberPws = {"memberPw1", "memberPw2", "memberPw3"};
        String[] memberNames = {"memberName1", "memberName2", "memberName3"};

        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:lifecycle_ctx.xml");

        MemberRegisterService memberRegisterService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
        MemberSearchService memberSearchService = ctx.getBean("memberSearchService", MemberSearchService.class);
        BookRegisterService bookRegisterService = ctx.getBean("bookRegisterService", BookRegisterService.class);
        BookSearchService bookSearchService = ctx.getBean("bookSearchService", BookSearchService.class);

        registerMembers(memberRegisterService, memberIds, memberPws, memberNames);
        Member member = memberSearchService.search("memberId1");

        bookRegisterService.register(new Book("bookID1", "bookTitle1", false, member));
        bookRegisterService.register(new Book("bookID2", "bookTitle2", false, member));

        System.out.println("대여된 도서 출력");
        for (String id : bookIds) {
            Book book = bookSearchService.search(id);
            if (book == null || book.isCanRental()) {
                continue;
            }
            System.out.println(book);
        }

        ctx.close();
    }

    private static void registerMembers(final MemberRegisterService memberRegisterService,
                                    final String[] memberIds,
                                    final String[] memberPws,
                                    final String[] memberNames) {
        for (int i = 0 ; i < memberIds.length ; i++) {
            memberRegisterService.register(new Member(memberIds[i], memberPws[i], memberNames[i]));
        }
    }

}
