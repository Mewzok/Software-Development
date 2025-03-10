import javafx.scene.control.Alert;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class DollarConverter {
    private static final NumberFormat dollarFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public static String formatToDollars(BigDecimal number) {
        try {
            return dollarFormatter.format(number);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(number + " could not be converted to dollar amount.");

            alert.showAndWait();
            return null;
        }
    }
}
