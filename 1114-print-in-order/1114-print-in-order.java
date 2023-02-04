class Foo {

        volatile int a;

        public Foo() {
            a = 1;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            while(a != 1);
            printFirst.run();
            a = 2;            
        }

        public void second(Runnable printSecond) throws InterruptedException {

            while (a != 2);                    
            printSecond.run();
            a = 3;            
        }

        public void third(Runnable printThird) throws InterruptedException {

            while (a != 3);
            printThird.run();                
        }
    }
