package com.example.myapplication.data.database.syncDatabase

object DatabaseContract {
    const val DATABASE_NAME = "MedicineApp.db"
    const val DATABASE_VERSION = 1

    object UserTable {
        const val TABLE_NAME = "User"
        const val COLUMN_USER_ID = "UserId"
        const val COLUMN_NAME = "Name"
        const val COLUMN_AGE = "Age"
        const val COLUMN_GENDER = "Gender"
        const val COLUMN_ROLE = "Role"

        const val CREATE_TABLE = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_USER_ID TEXT PRIMARY KEY,
                $COLUMN_NAME TEXT,
                $COLUMN_AGE INTEGER,
                $COLUMN_GENDER INTEGER,
                $COLUMN_ROLE INTEGER
            )
        """
    }

    object MedicineTable {
        const val TABLE_NAME = "Medicine"
        const val COLUMN_MEDICINE_ID = "MedicineId"
        const val COLUMN_USER_ID = "UserId"
        const val COLUMN_FUNCTION = "Function"
        const val COLUMN_USAGE = "Usage"
        const val COLUMN_NOTE = "Note"
        const val COLUMN_STORAGE_CONDITION = "StorageCondition"
        const val COLUMN_INGREDIENTS = "Ingredients"
        const val COLUMN_MEAL_SCHEDULE = "MealSchedule"
        const val COLUMN_QUANTITY_LEFT = "QuantityLeft"
        const val COLUMN_WAREHOUSE_NO = "WarehouseNo"
        const val COLUMN_TIMES_PER_DAY = "TimesPerDay"

        const val CREATE_TABLE = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_MEDICINE_ID TEXT PRIMARY KEY,
                $COLUMN_USER_ID TEXT,
                $COLUMN_FUNCTION TEXT,
                $COLUMN_USAGE TEXT,
                $COLUMN_NOTE TEXT,
                $COLUMN_STORAGE_CONDITION TEXT,
                $COLUMN_INGREDIENTS TEXT,
                $COLUMN_MEAL_SCHEDULE INTEGER,
                $COLUMN_QUANTITY_LEFT INTEGER,
                $COLUMN_WAREHOUSE_NO INTEGER,
                $COLUMN_TIMES_PER_DAY INTEGER,
                FOREIGN KEY($COLUMN_USER_ID) REFERENCES ${UserTable.TABLE_NAME}(${UserTable.COLUMN_USER_ID})
            )
        """
    }

    object ReportTable {
        const val TABLE_NAME = "Report"
        const val COLUMN_REPORT_ID = "ReportId"
        const val COLUMN_USER_ID = "UserId"
        const val COLUMN_PERIOD = "Period"
        const val COLUMN_SUCCESS = "Success"
        const val COLUMN_FAIL = "Fail"

        const val CREATE_TABLE = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_REPORT_ID TEXT PRIMARY KEY,
                $COLUMN_USER_ID TEXT,
                $COLUMN_PERIOD TEXT,
                $COLUMN_SUCCESS INTEGER,
                $COLUMN_FAIL INTEGER,
                FOREIGN KEY($COLUMN_USER_ID) REFERENCES ${UserTable.TABLE_NAME}(${UserTable.COLUMN_USER_ID})
            )
        """
    }

    object SchedulingTable {
        const val TABLE_NAME = "Scheduling"
        const val COLUMN_SCHEDULE_ID = "ScheduleId"
        const val COLUMN_MEDICINE_ID = "MedicineId"
        const val COLUMN_QUANTITY = "Quantity"
        const val COLUMN_HOUR = "Hour"
        const val COLUMN_MIN = "Min"

        const val CREATE_TABLE = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_SCHEDULE_ID TEXT PRIMARY KEY,
                $COLUMN_MEDICINE_ID TEXT,
                $COLUMN_QUANTITY INTEGER,
                $COLUMN_HOUR INTEGER,
                $COLUMN_MIN INTEGER,
                FOREIGN KEY($COLUMN_MEDICINE_ID) REFERENCES ${MedicineTable.TABLE_NAME}(${MedicineTable.COLUMN_MEDICINE_ID})
            )
        """
    }
}