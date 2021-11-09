package com.wenjiehe.leetcode.duoxiancheng;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class P1114 {

    private static CountDownLatch first = new CountDownLatch(1);
    private static CountDownLatch second = new CountDownLatch(1);

    public static void main(String[] args) {

        int[] sort = new int[]{1, 2, 0};

        Runnable[] runnables = new Runnable[3];
        for (int i = 0; i < sort.length; i++) {
            int count = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("cixu:" + count);
                }
            };
            runnables[i] = runnable;

        }

        for (int i = 0; i < sort.length; i++) {
            switch (sort[i]) {
                case 0: {
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            printFirst(runnables[0]);
                        }
                    }.start();
                    break;
                }
                case 1:
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            printSecond(runnables[1]);
                        }
                    }.start();
                    break;
                case 2:
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            printThird(runnables[2]);
                        }
                    }.start();
            }
        }
    }


    public static void printFirst(Runnable firstRunnable) {
        firstRunnable.run();
        first.countDown();
    }


    public static void printSecond(Runnable secondRunnable) {
        try {
            first.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        secondRunnable.run();
        second.countDown();
    }

    public static void printThird(Runnable thirdRunnable) {
        try {
            second.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thirdRunnable.run();
    }


    static class Part2 {
        private static final Semaphore first_second = new Semaphore(0);
        private static final Semaphore second_third = new Semaphore(0);

        public static void main(String[] args) {


            int[] sort = new int[]{1, 0,2};

            Runnable[] runnables = new Runnable[3];
            for (int i = 0; i < sort.length; i++) {
                int count = i;
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("cixu:" + count);
                    }
                };
                runnables[i] = runnable;

            }

            for (int i = 0; i < sort.length; i++) {
                switch (sort[i]) {
                    case 0: {
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                printFirst2(runnables[0]);
                            }
                        }.start();
                        break;
                    }
                    case 1:
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                printSecond2(runnables[1]);
                            }
                        }.start();
                        break;
                    case 2:
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                printThird2(runnables[2]);
                            }
                        }.start();
                }
            }
        }

        public static void printFirst2(Runnable firstRunnable) {
            firstRunnable.run();
            first_second.release();
        }


        public static void printSecond2(Runnable secondRunnable) {
            try {
                first_second.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondRunnable.run();
            second_third.release();
        }


        public static void printThird2(Runnable thirdRunnable) {
            try {
                second_third.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thirdRunnable.run();
        }
    }
}
