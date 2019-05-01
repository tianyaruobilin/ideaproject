package com.study.sstream;

import com.study.sstream.stream.streamparallel.StreamOperate;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        StreamOperate.parallel(2L);
    }
}
