/**
 * Manages persistence and retrieval of DailyRecord objects. Saves records to
 * and loads records from a CSV data store. Currently a stub awaiting
 * full CSV integration.
 */
package service;

import model.DailyRecord;
import java.util.List;

public class HistoryManager {

    /**
     * Persists a single DailyRecord to the CSV data store.
     *
     * @param record the record to save
     */
    public void saveRecord(DailyRecord record) {
        // TODO: implement CSV write logic for a single record
    }

    /**
     * Loads all previously saved DailyRecord objects from the CSV data store.
     *
     * @return a list of all saved records, or an empty list if none exist
     */
    public List<DailyRecord> loadRecords() {
        // TODO: implement CSV read logic and return populated list
        return List.of();
    }
}
