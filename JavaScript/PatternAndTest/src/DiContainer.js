DiContainer = function() {
    // 반드시 생성자로 객체를 생성하게 한다.
    if (!(this instanceof DiContainer)) {
        return new DiContainer();
    }

    this.registrations = [];
};

DiContainer.prototype.messages = {
    registerRequiresArgs: '이 생성자 함수는 인자가 3개 있어햐 합니다 : ' +
        '문자열, 문자열 배열, 함수'
};

/**
 *
 * @param name : 인젝터블 이름
 * @param dependencies : 의존성 명을 담은 배열
 * @param func : 인젝터블 객체를 반환하는 함수
 */
DiContainer.prototype.register = function (name, dependencies, func) {
    var ix;

    if (typeof name !== 'string' ||
        !Array.isArray(dependencies) ||
        typeof func !== 'function') {
        throw new Error(this.messages.registerRequiresArgs);
    }

    for (ix = 0 ; ix < dependencies.length ; ++ix) {
        if (typeof dependencies[ix] !== 'string') {
            throw new Error(this.messages.registerRequiresArgs);
        }
    }

    this.registrations[name] = {
        dependencies: dependencies,
        func: func
    };

};

DiContainer.prototype.get = function (name) {
    var self,
        registration = this.registrations[name],
        dependencies = [];

    if (registration === undefined) {return undefined;}

    registration.dependencies.forEach(function(dependencyName) {
        var dependency = self.get(dependencyName);
        dependencies.push(dependency === undefined ? undefined : dependency);
    });

    return registration.func.apply(undefined, dependencies);
};