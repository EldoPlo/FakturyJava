import com.example.DataBaseConnectionI;
import com.example.Invoice;
import com.example.Store;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.*;

public class StoreTest
{
    @Test
    public void testSave()
    {
        Store store = initStore();

        assertDoesNotThrow(store::save);
    }

    @Test
    public void addInvoiceTest()
    {
        // Arrange
        Store store = initStore();
        String clientName = "Client 1";
        int expectedIndex = 0;
        int expectedNumberOfInvoices = 1;
        Invoice expectedInvoice = new Invoice(clientName);

        // Act
        store.addInvoice(clientName);

        // Assert
        assertEquals(expectedNumberOfInvoices, store.getInvoices().size());

        assertThat(store.getInvoices().get(expectedIndex))
                .usingRecursiveComparison()
                .isEqualTo(expectedInvoice);
    }

    @Test
    public void addItemToEmptyStore()
    {
        // Arrange
        Store store = initStore();
        int nonExistingIndex = 0;
        String article = "Article";
        int quantity = 10;
        double price = 0.0;
        String expectedError = "This invoice does not exits";

        // Act + Assert
        Exception e = assertThrows(Exception.class, () -> {
            store.addItemToInvoice(nonExistingIndex, article, quantity, price);
        });

        assertEquals(e.getMessage(), expectedError);
    }

    private static Store initStore()
    {
        DataBaseConnectionI dataBaseConnection = mock(DataBaseConnectionI.class);

        return new Store(dataBaseConnection);
    }

}
