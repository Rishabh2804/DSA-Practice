class Foo {

        int a;

        public Foo() {
            a = 1;
        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (this) {
                printFirst.run();
                a = 2;
                notifyAll();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.

        }

        public void second(Runnable printSecond) throws InterruptedException {

            synchronized (this) {
                while (a < 2)
                    wait();
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                a = 3;
                notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {

            synchronized (this) {
                while (a < 3)
                    wait();
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();                                              
            }

        }
    }
