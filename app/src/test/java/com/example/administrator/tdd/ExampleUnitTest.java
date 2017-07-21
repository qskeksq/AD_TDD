package com.example.administrator.tdd;

import android.content.Context;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
    // 각각의 인스턴스를 만들어서 테스트 해 주는군. 그래서 색별로 나눠서 보여지는 것이다.

    // 목 만들어줌
    @Mock
    static Context context;

    static NetWorker netWorker;

    @BeforeClass    // 전체 클래스 테스트 이전, 이후, 인스턴스가 만들어 지기 이전이기 떄문에 static 으로 해 줘야 한다. 당연히 한 번 씩만 실행된다.
    public static void log_beforeClass(){
        System.out.println("BeforeClass");

        // 목업이라는 것은 어떤 동작할 떄 뭐를 줄지 맵핑을 해주는 것인다. 호출할 떄 정상 동작하도록 하는게 목업인데,
        // 이걸 안 해 주면 모두 비어있는 값이 반환된다.
//        when(context.getString(R.string.app_name)).thenReturn("TestApplication");
//        netWorker = new NetWorker(context);
    }
    @AfterClass
    public static void log_afterClass(){
        System.out.println("AfterClass");
    }

    //    @Before     각각 테스트 메소드별로 이전 이후에 실행된다. 메소드 100개 있으면 100번 실행됨
    //    @After
    @Before
    public void log_before(){
        // 각각 테스트마다 값을 초기화 해 줘야 한다면 before 에서 해준 코드는 모든 메소드 이전에 호출되기 때문에 짧은 코드로 같은 효과를 낼 수 있다.
        System.out.println("Before");
        when(context.getString(R.string.app_name)).thenReturn("TestApplication");
        netWorker = new NetWorker(context);

    }
    @After
    public void log_after(){
        System.out.println("After");
    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    @Test       // 이거 하나만 테스트 하고 싶은 여기에 마우스 올리고 실행하자.
    public void testNetWorker(){
        // 참고로 jvm 에서 돌아가기 때문에 localhost 로 해줘야 함
        // 참고2 객체지향적 코딩을 하지 않고, 서로 의존성이 생기면 테스트를 할 수 없다. 따로 객체로 다 뺴줘야 한다.

        assertEquals("okTestApplication", netWorker.doNetWork());
        // befor class 가 어디서 써야 하는가, 바로 전체 테스트에서 객체를 사용해야 할 경우 여기서 미리 초기화 해 두고 전체 클래스에서 참조해 쓴다.

    }

    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    //여기서는 자바 패키지의 요소들만 가져다 쓸 수 있다. 따라서 log  와 같이 android 요소들을 가져다 쓰려면 목업을 해줘야 한다.



}