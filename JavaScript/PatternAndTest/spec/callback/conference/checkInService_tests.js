describe('Conference.checkInService', function () {
    var checkInService, checkInRecorder, attendee;

    beforeEach(function () {
        checkInRecorder = Conference.checkInRecorder();
        spyOn(checkInRecorder, 'recordCheckIn');

        checkInService = Conference.checkInService(checkInRecorder);
        attendee = Conference.attendee('민호', '오');
    });

    describe('checkInService.checkIn(attendee)', function () {
        it('참가자를 체크인 처리한 것으로 표시한다', function () {
            checkInService.checkIn(attendee);
            expect(attendee.isCheckedIn()).toBe(true);
        });

        it('체크인을 등록한다', function () {
            checkInService.checkIn(attendee);
            expect(checkInRecorder.recordCheckIn).toHaveBeenCalledWith(attendee);
        });

    });
});