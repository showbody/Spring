package com.yc;

import org.ycframework.annotation.YcComponent;
import org.ycframework.annotation.YcLazy;
import org.ycframework.annotation.YcScope;

@YcComponent
@YcScope(value = "prototype")
@YcLazy(value = false)
public class App {
}
