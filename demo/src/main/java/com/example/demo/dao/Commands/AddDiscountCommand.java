package com.example.demo.dao.Commands;

import com.example.demo.GUI.CustomerViewController;
import com.example.demo.dao.Command;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLine;
import javafx.scene.control.TableView;

public class AddDiscountCommand implements Command {
    private final TableView<OrderLine> orderTable;
    private CustomerViewController customerViewController;
    private final Order currentOrder;
    private final TableView<OrderLine> orderTable2;
    private int quantity;
    private final double discount;

    public AddDiscountCommand(TableView<OrderLine> orderTable2, TableView<OrderLine> orderTable, Order currentOrder, int quantity, double discount) {
        this.orderTable2 = orderTable2;
        this.orderTable = orderTable;
        this.currentOrder = currentOrder;
        this.quantity = quantity;
        this.discount = discount;
    }

    @Override
    public void execute() {
        OrderLine ol = orderTable.getSelectionModel().getSelectedItem();

        orderTable2.getItems().remove(ol);
        orderTable.getItems().remove(ol);
        currentOrder.getOrderLineSet().remove(ol);

        if (quantity == -1) {
            quantity = ol.getQuantity();
        }

        OrderLine discountedProducts = new OrderLine(currentOrder.getOrderNumber(), ol);
        discountedProducts.changeQuantity(quantity);
        discountedProducts.setDiscount(discount);
        ol.changeQuantity(ol.getQuantity() - quantity);

        if(ol.getQuantity() != 0) {
            currentOrder.addOrderLine(ol);
            orderTable2.getItems().add(ol);
            orderTable.getItems().add(ol);
        }

        AddNewOrderLineCommand addCommand = new AddNewOrderLineCommand(orderTable2, orderTable, currentOrder, discountedProducts);
        addCommand.execute();
    }
}
