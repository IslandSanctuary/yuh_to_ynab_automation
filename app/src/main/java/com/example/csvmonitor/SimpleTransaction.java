package com.example.csvmonitor;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SimpleTransaction {
    public static final SimpleTransaction testTransaction = new SimpleTransaction(
            null,
            "2025-07-06",
            0,
            "test",
            "test"
    );

    @SerializedName("account_id")
    public String accountId;

    @SerializedName("date")
    public String date;

    @SerializedName("amount")
    public int amount;

    @SerializedName("payee_id")
    public String payeeId = null;

    @SerializedName("payee_name")
    public String payeeName;

    @SerializedName("category_id")
    public String categoryId = null;

    @SerializedName("memo")
    public String memo;

    @SerializedName("cleared")
    public String cleared = null;

    @SerializedName("approved")
    public Boolean approved = null;

    @SerializedName("flag_color")
    public String flagColor = null;

    @SerializedName("subtransactions")
    public List<SimpleTransaction> subtransactions = null;

    @SerializedName("import_id")
    public String importId = null;

    // Constructor for the fields actually used
    public SimpleTransaction(String accountId,
                             String date,
                             int amount,
                             String payeeName,
                             String memo) {
        this.accountId = accountId;
        this.date = date;
        this.amount = amount;
        this.payeeName = payeeName;
        this.memo = memo;
    }
}
