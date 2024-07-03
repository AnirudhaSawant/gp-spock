def fibonacci(n) {

    if(n < 2) {
        throw new IllegalArgumentException("value must be greater than 2")
    }

    def fibList = [0, 1]
    for (int i = 2; i < n; i++) {
        fibList << fibList[-1] + fibList[-2]
    }
    fibList
}


