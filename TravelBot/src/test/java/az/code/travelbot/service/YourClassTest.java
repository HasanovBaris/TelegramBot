package az.code.travelbot.service;

import az.code.travelbot.models.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class YourClassTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private YourClass yourClass;

    @Test
    void testSetShareContactUserNotExists() {

        MockitoAnnotations.openMocks(this);


        when(userService.getUserByChatId(1234L)).thenReturn(null);


        Update update = new Update();
        update.getMessage().setChatId(1234L);


        ReplyKeyboard result = yourClass.setShareContact(update);

        assertNotNull(result);
        assertTrue(result instanceof ReplyKeyboardMarkup);
        ReplyKeyboardMarkup replyKeyboardMarkup = (ReplyKeyboardMarkup) result;
        assertTrue(replyKeyboardMarkup.isSelective());
        assertTrue(replyKeyboardMarkup.isResizeKeyboard());
        assertTrue(replyKeyboardMarkup.isOneTimeKeyboard());
        assertEquals(1, replyKeyboardMarkup.getKeyboard().size());
        assertEquals("share contact", replyKeyboardMarkup.getKeyboard().get(0).get(0).getText());
        assertTrue(replyKeyboardMarkup.getKeyboard().get(0).get(0).isRequestContact());
    }

    @Test
    void testSetShareContactUserExists() {

        MockitoAnnotations.openMocks(this);


        when(userService.getUserByChatId(5678L)).thenReturn(new User());


        Update update = new Update();
        update.getMessage().setChatId(5678L);


        ReplyKeyboard result = yourClass.setShareContact(update);


        assertNull(result);
    }
}
