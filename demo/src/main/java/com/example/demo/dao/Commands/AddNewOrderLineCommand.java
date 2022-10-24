package com.example.demo.dao.Commands;

import com.example.demo.dao.Command;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLine;
import javafx.scene.control.TableView;

public class AddNewOrderLineCommand implements Command {
    private final Order currentOrder;
    private final OrderLine ol;

    private final TableView<OrderLine> orderTable;

    public AddNewOrderLineCommand(TableView<OrderLine> orderTable, Order currentOrder, OrderLine orderLine) {
        this.orderTable = orderTable;
        this.currentOrder = currentOrder;
        this.ol = orderLine;
    }

    @Override
    public void execute() {
        String orderNr = currentOrder.getOrderNumber();
        currentOrder.addOrderLine(ol);
        orderTable.getItems().add(ol);
    }
}
