package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillDetail {
    private int id;
    private int idBill;
    private int idProduct;
    private int buyAmount;
    private Date date;
    private Double totalMoney;
}
