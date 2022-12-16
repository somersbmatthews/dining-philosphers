package com.revature.dining;

import java.util.concurrent.Semaphore;

abstract class ChopstickBase {



    abstract void grab();

    abstract boolean tryGrab();

    abstract void release();

    abstract boolean isFree();
}
