package com.example.androidfundamentals032;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
@InjectMocks
    private  MainActivity mainActivity = new MainActivity();

@Mock
    Calculator calculator;

    @Test
    public void calcButton(){
        /*you can remove the when to see how test fails.
        as with mockito we are mocking the dependency of calcButton in calculator.add
        */
        when(calculator.add(-6, 1)).thenReturn(-5d);
        assertEquals(mainActivity.calcButton(),calculator.add(-6,1));
        //we can use a mock framework to create fake ("mock") objects that pretend to be dependencies.
}

}

