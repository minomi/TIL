var Conference = Conference || {};

Conference.checkInService = function (checkInRecorder) {
    var recorder = checkInRecorder;

    return {
        checkIn : function (attendee) {
            attendee.checkIn();
            recorder.recordCheckIn(attendee);
        }
    }
};

Conference.checkInRecorder = function () {
    return {
        recordCheckIn : function (attendee) {
            console.log('외부에 ', attendee, '의 등록 기록을 저장함');
        }
    };
};