package com.gmail.xlinaris.lesson05;

import java.util.Arrays;

import static com.gmail.xlinaris.lesson05.MyThreadTest.TestThreads.calculateElements;

class MyThreadTest {

    public static final int size = 10000000;
    public static final int h = size / 2;
    protected static float[] arr, a1, a2, parallelArr, sequentArr;

    MyThreadTest(int sizeArray) {
        arr = new float[sizeArray];
        Arrays.fill(arr, 1);
    }

    static class Test implements Runnable {

        int part;

        Test(int part) {
            this.part = part;
        }

        @Override
        public void run() {
            float[] a= new float[h]; float[] b= new float[h];
            if (part != 0) {
                System.arraycopy(arr, 0, a, 0, h);
                a2 = calculateElements(a, h, part);
            } else {
                System.arraycopy(arr, h, b, 0, h);
                a1 = calculateElements(b, h, part);
            }
        }
    }

    public static class TestThreads {

        public static void main(String[] args) throws InterruptedException {
            //Test method with 1 thread for computed the array.
            sequentialThreadComputed();
            //Test method with 2 parallel thread for computed the array.
            parallelTreadComputed();
            //Compare arrays
            System.out.println("Array by computed method with 1 thread is equals to the array by computed method with 2 parallel threads: " + Arrays.equals(sequentArr, parallelArr));
        }

        //Method for computed the array
        protected static float[] calculateElements(float[] arr, int size, int part) {
            int k,i=0;
            if (part!=0) k=h+i; else k=i;
            for (i = 0; i < size; i++, k++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + k / 5) * Math.cos(0.2f + k / 5) * Math.cos(0.4f + k / 2));
            }
            return arr;
        }

        //Method with 1 thread for computed the array.
        private static void sequentialThreadComputed() {
            MyThreadTest myThreadTest = new MyThreadTest(size);
            long timeIn = System.currentTimeMillis();

            sequentArr = calculateElements(arr, size,0);
            long timeOut = System.currentTimeMillis();
            long timeLength = timeOut - timeIn;

            System.out.println("All computed operation on array by using method with 1 thread: " + timeLength + " ms.");
        }

        //Method with 2 parallel thread for computed the array.
        private static void parallelTreadComputed() throws InterruptedException {

            MyThreadTest myThreadTest = new MyThreadTest(size);
            long timeIn = System.currentTimeMillis();

            Thread thread1 = new Thread(new Test(0));
            Thread thread2 = new Thread(new Test(1));
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            if (!thread1.isAlive() & !thread2.isAlive()) {
                System.arraycopy(a1, 0, arr, 0, h);
                System.arraycopy(a2, 0, arr, h, h);
                parallelArr = arr;
            }

            long timeOut = System.currentTimeMillis();
            long timeLength = timeOut - timeIn;
            System.out.println("All computed operation on array by using method with 2 parallel threads: " + timeLength + " ms.");
        }
    }
}
