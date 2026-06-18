/**
 * Utility class for CSV file operations. Handles serialization and
 * deserialization of DailyRecord objects to/from CSV format for
 * persistent data storage. Currently a stub awaiting implementation.
 */
package util;

import model.DailyRecord;
import java.util.List;

public class CSVUtil {

    /**
     * Writes a list of DailyRecord objects to the specified CSV file.
     *
     * @param filePath the path to the CSV file
     * @param records  the list of records to write
     */
    public void writeCSV(String filePath, List<DailyRecord> records) {
        // TODO: implement CSV writing logic
    }

    /**
     * Reads DailyRecord objects from the specified CSV file.
     *
     * @param filePath the path to the CSV file
     * @return a list of deserialized DailyRecord objects
     */
    public List<DailyRecord> readCSV(String filePath) {
        // TODO: implement CSV reading logic
        return List.of();
    }
}
