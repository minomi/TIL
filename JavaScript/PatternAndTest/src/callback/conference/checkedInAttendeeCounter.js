var Conference = Conference || {};

Conference.checkInAttendeeCounter = function () {
    var count = 0;
    var self = {
        increment : function() {
            count++;
        },
        countIfCheckedIn : function (attendee) {
            if (!attendee.isCheckedIn()) {
                return;
            }
            self.increment();
        },
        getCounter : function () {
            return count;
        }
    };
    return self;
};