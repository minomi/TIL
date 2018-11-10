describe('Conference.checkedInAttendeeCounter', function () {
    var counter;

    beforeEach(function () {
        counter = Conference.checkInAttendeeCounter();
    });

    describe('checkedInAttendeeCounter', function () {
        var attendee;

        beforeEach(function () {
            attendee = Conference.attendee('민호', '오');
        });

        it('참가자가 체크인 하지 않았다면 인원수를 세지 않는다.', function () {
            counter.countIfCheckedIn(attendee);
            expect(counter.getCounter()).toBe(0);
        });

        it('참가자가 체크인 했다면 인원수를 센다', function () {
            attendee.checkIn();
            counter.countIfCheckedIn(attendee);
            expect(counter.getCounter()).toBe(1);
        });


        it('this 가 꼭 checkedInAttendee 를 가르키는 것은 아니다', function () {
            attendee.checkIn();
            counter.countIfCheckedIn.call({}, attendee);
            expect(counter.getCounter()).toBe(1);
        })
    });
});