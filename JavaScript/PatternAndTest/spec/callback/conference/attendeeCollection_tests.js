describe('Conference.attendeeCollection', function () {
    describe('contains(attendee)', function () {
        // contains 테스트
    });

    describe('add(attendee)', function () {
        // add 테스트
    });

    describe('remove(attendee)', function () {
        // remove 테스트
    });

    describe('iterate(callback)', function () {
        var collection, callbackSpy;

        function addAttendessToCollection(attendeeArray) {
            attendeeArray.forEach(function (attendee) {
                collection.add(attendee);
            });
        }

        function verifyCallbackWasExecutedForEachAttendee(attendeeArray) {
            expect(callbackSpy.calls.count()).toBe(attendeeArray.length);

            var allCalls = callbackSpy.calls.all();
            for (var i = 0 ; i < allCalls.length ; i++) {
                expect(allCalls[i].args[0]).toBe(attendeeArray[i]);
            }
        }

        beforeEach(function () {
            collection = Conference.attendeeCollection();
            callbackSpy = jasmine.createSpy();
        });

        it('빈 컬렉션에서는 콜백을 실행하지 않는다.', function () {
            collection.iterate(callbackSpy);
            expect(callbackSpy).not.toHaveBeenCalled();
        });

        it('원소가 하나뿐인 컬렉션은 콜백을 한 번만 실행한다', function () {
            var attendees = [
                Conference.attendee('Tom', 'kazansky'),
                Conference.attendee('Charlotte', 'Blackwood'),
                Conference.attendee('태영', '김'),
            ];
            addAttendessToCollection(attendees);
            collection.iterate(callbackSpy);
            verifyCallbackWasExecutedForEachAttendee(attendees);
        });
    })
});