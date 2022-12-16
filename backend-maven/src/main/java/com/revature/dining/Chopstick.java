package com.revature.dining;

import java.util.concurrent.Semaphore;

public class Chopstick extends ChopstickBase{

   private Semaphore mutex = new Semaphore(1);

    @Override
    public void grab() {
        try {
            mutex.acquire();
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public boolean tryGrab() {
        return mutex.tryAcquire();
    }

    @Override
    public void release() {
        mutex.release();
    }

    @Override
    public boolean isFree() {
        return mutex.availablePermits() > 0;
    }
}
