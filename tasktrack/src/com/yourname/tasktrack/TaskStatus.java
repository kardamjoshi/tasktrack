package com.yourname.tasktrack;

public sealed interface TaskStatus permits Todo,InProgress,Done,Blocked {}
