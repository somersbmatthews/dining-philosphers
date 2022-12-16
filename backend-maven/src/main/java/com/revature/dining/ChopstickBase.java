package com.revature.dining;

import java.util.concurrent.Semaphore;

abstract class ChopstickBase {



    abstract void grab();

    abstract void release();

    abstract boolean tryGrab();

    abstract boolean isFree();
}
