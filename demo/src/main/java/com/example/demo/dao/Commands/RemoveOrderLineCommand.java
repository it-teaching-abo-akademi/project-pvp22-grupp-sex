package com.example.demo.dao.Commands;

import com.example.demo.dao.Command;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLine;
import javafx.scene.control.TableView;

public class RemoveOrderLineCommand implements Command {
    private TableView<OrderLine> orderTable;
    private Order currentOrder;
    public RemoveOrderLineCommand(TableView<OrderLine> orderTable, Order currentOrder) {
        this.orderTable = orderTable;
        this.currentOrder = currentOrder;
    }

    @Override
    public void execute() {
        OrderLine olToRemove = orderTable.getSelectionModel().getSelectedItem();
        orderTable.getItems().remove(olToRemove);
    }
}
