package sergiocrespotoubes.com.unedsecuredsoftware;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import sergiocrespotoubes.com.unedsecuredsoftware.contacts.interfaces.IContactsView;
import sergiocrespotoubes.com.unedsecuredsoftware.contacts.presenter.ContactsPresenter;
import sergiocrespotoubes.com.unedsecuredsoftware.database.repository.UsersRepository;
import sergiocrespotoubes.com.unedsecuredsoftware.login.interfaces.ILoginView;
import sergiocrespotoubes.com.unedsecuredsoftware.login.presenter.LoginPresenter;
import sergiocrespotoubes.com.unedsecuredsoftware.main.interfaces.IMainView;
import sergiocrespotoubes.com.unedsecuredsoftware.main.presenter.MainPresenter;
import sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.interfaces.IMemoryActivitiesView;
import sergiocrespotoubes.com.unedsecuredsoftware.memory_activities.presenter.MemoryActivitiesPresenter;
import sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.interfaces.IOverflowIntView;
import sergiocrespotoubes.com.unedsecuredsoftware.overflow_int.presenter.OverflowIntPresenter;
import sergiocrespotoubes.com.unedsecuredsoftware.register.interfaces.IRegisterView;
import sergiocrespotoubes.com.unedsecuredsoftware.register.presenter.RegisterPresenter;
import sergiocrespotoubes.com.unedsecuredsoftware.splash.interfaces.ISplashView;
import sergiocrespotoubes.com.unedsecuredsoftware.splash.presenter.SplashPresenter;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Before
    public void setUp() {
        //InstrumentationRegistry.getInstrumentation().newActivity();
    }

    ContactsPresenter contactsPresenter;
    LoginPresenter loginPresenter;
    UsersRepository usersRepository;
    MainPresenter mainPresenter;
    MemoryActivitiesPresenter memoryActivitiesPresenter;
    OverflowIntPresenter overflowIntPresenter;
    RegisterPresenter registerPresenter;
    SplashPresenter splashPresenter;

    @Test
    public void TestAll(){

        contactsPresenter = new ContactsPresenter(activity, new IContactsView() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        loginPresenter = new LoginPresenter(activity, new ILoginView() {
            @Override
            public void errorLogin(String error) {

            }

            @Override
            public void enableForm(boolean enable) {

            }
        });
        mainPresenter = new MainPresenter(activity, new IMainView() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        memoryActivitiesPresenter = new MemoryActivitiesPresenter(activity, new IMemoryActivitiesView() {
            @Override
            public void changeStackValue(int stackNumber) {

            }
        });
        overflowIntPresenter = new OverflowIntPresenter(activity, new IOverflowIntView() {
            @Override
            public void showToast(String message) {

            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        registerPresenter = new RegisterPresenter(activity, new IRegisterView() {
            @Override
            public void showMessageError(String string) {

            }
        });
        splashPresenter = new SplashPresenter(activity, new ISplashView() {
            @Override
            public void startApplication() {

            }
        });

        testContacts();
        testLogin();
        testMain();
        testMemoryActivities();
        testOverflowInt();
        testRegister();
        testSplash();
    }

    private void testContacts() {

        contactsPresenter.setupActionBar(toolbar);

        ListView listView = new ListView(this);
        contactsPresenter.loadContacts(listView);
    }

    private void testLogin() {
        loginPresenter.setupActionBar(toolbar);

        loginPresenter.loadRegister();

        //char[]password = "password".toCharArray();
        //loginPresenter.login("Sergio", password);
    }

    private void testMain() {

        mainPresenter.setupActionBar(toolbar);

        mainPresenter.loadOverflowInt();
        mainPresenter.logout();
        mainPresenter.contactsClick();
        mainPresenter.openContacts();
        mainPresenter.loadActivitiesMemory();
        mainPresenter.loadOverflowInt();
    }

    private void testMemoryActivities() {
        memoryActivitiesPresenter.setupActionBar(toolbar);

        //memoryActivitiesPresenter.addActivity();

        //memoryActivitiesPresenter.clearActivity();

        //memoryActivitiesPresenter.loadStackNumber(5);
    }

    private void testOverflowInt() {

        overflowIntPresenter.setupActionBar(toolbar);

        /* Byte */
        overflowIntPresenter.checkByte("34535234646323");
        overflowIntPresenter.checkByte("sdafsdf6fds56f");
        overflowIntPresenter.checkByte("ASFASF");
        overflowIntPresenter.checkByte("1");
        overflowIntPresenter.checkByte("0");
        overflowIntPresenter.checkByte("-3252");
        overflowIntPresenter.checkByte("");
        overflowIntPresenter.checkByte("3456asf");
        overflowIntPresenter.checkByte("34534");
        overflowIntPresenter.checkByte("2352f");
        overflowIntPresenter.checkByte("34563.34534");
        overflowIntPresenter.checkByte("3453.");
        overflowIntPresenter.checkByte(".");

        /* Int */
        overflowIntPresenter.checkInt("34535234646323");
        overflowIntPresenter.checkInt("sdafsdf6fds56f");
        overflowIntPresenter.checkInt("ASFASF");
        overflowIntPresenter.checkInt("1");
        overflowIntPresenter.checkInt("0");
        overflowIntPresenter.checkInt("-3252");
        overflowIntPresenter.checkInt("");
        overflowIntPresenter.checkInt("3456asf");
        overflowIntPresenter.checkInt("34534");
        overflowIntPresenter.checkInt("2352f");
        overflowIntPresenter.checkInt("34563.34534");
        overflowIntPresenter.checkInt("3453.");
        overflowIntPresenter.checkInt(".");

        /* Float */
        overflowIntPresenter.checkFloat("34535234646323");
        overflowIntPresenter.checkFloat("sdafsdf6fds56f");
        overflowIntPresenter.checkFloat("ASFASF");
        overflowIntPresenter.checkFloat("1");
        overflowIntPresenter.checkFloat("0");
        overflowIntPresenter.checkFloat("-3252");
        overflowIntPresenter.checkFloat("");
        overflowIntPresenter.checkFloat("3456asf");
        overflowIntPresenter.checkFloat("34534");
        overflowIntPresenter.checkFloat("2352f");
        overflowIntPresenter.checkFloat("34563.34534");
        overflowIntPresenter.checkFloat("3453.");
        overflowIntPresenter.checkFloat(".");

        /* Double */
        overflowIntPresenter.checkDouble("34535234646323");
        overflowIntPresenter.checkDouble("sdafsdf6fds56f");
        overflowIntPresenter.checkDouble("ASFASF");
        overflowIntPresenter.checkDouble("1");
        overflowIntPresenter.checkDouble("0");
        overflowIntPresenter.checkDouble("-3252");
        overflowIntPresenter.checkDouble("");
        overflowIntPresenter.checkDouble("3456asf");
        overflowIntPresenter.checkDouble("34534");
        overflowIntPresenter.checkDouble("2352f");
        overflowIntPresenter.checkDouble("34563.34534");
        overflowIntPresenter.checkDouble("3453.");
        overflowIntPresenter.checkDouble(".");

        /* Long */
        overflowIntPresenter.checkLong("34535234646323");
        overflowIntPresenter.checkLong("sdafsdf6fds56f");
        overflowIntPresenter.checkLong("ASFASF");
        overflowIntPresenter.checkLong("1");
        overflowIntPresenter.checkLong("0");
        overflowIntPresenter.checkLong("-3252");
        overflowIntPresenter.checkLong("");
        overflowIntPresenter.checkLong("3456asf");
        overflowIntPresenter.checkLong("34534");
        overflowIntPresenter.checkLong("2352f");
        overflowIntPresenter.checkLong("34563.34534");
        overflowIntPresenter.checkLong("3453.");
        overflowIntPresenter.checkLong(".");

        /* Short */
        overflowIntPresenter.checkShort("34535234646323");
        overflowIntPresenter.checkShort("sdafsdf6fds56f");
        overflowIntPresenter.checkShort("ASFASF");
        overflowIntPresenter.checkShort("1");
        overflowIntPresenter.checkShort("0");
        overflowIntPresenter.checkShort("-3252");
        overflowIntPresenter.checkShort("");
        overflowIntPresenter.checkShort("3456asf");
        overflowIntPresenter.checkShort("34534");
        overflowIntPresenter.checkShort("2352f");
        overflowIntPresenter.checkShort("34563.34534");
        overflowIntPresenter.checkShort("3453.");
        overflowIntPresenter.checkShort(".");
    }

    private void testRegister() {
        registerPresenter.createUser("Sergio", "password", "password", "email@gmail.com", "12");
        registerPresenter.createUser("Sergio", "password", "password1", "email", "12");
        registerPresenter.createUser("Sergio", "password1", "password", "email", "12");
        registerPresenter.createUser("3653", "password1", "password", "email", "12");
        registerPresenter.createUser("3653", "password", "password", "email", "12");
        registerPresenter.createUser("3653", "password", "password", "email@gmail.com", "47457347");
    }

    private void testSplash() {
        splashPresenter.startApplication();
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("sergiocrespotoubes.com.myapplication", appContext.getPackageName());
        assert
    }
}
