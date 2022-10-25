package com.example.demo.dao.Commands;

import com.example.demo.dao.Command;
import com.example.demo.model.Order;
import com.example.demo.model.OrderLine;
import javafx.scene.control.TableView;

import java.util.Optional;

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
        Optional<OrderLine> existingProduct = currentOrder.getOrderLineSet().stream().filter(o -> o.getBarcode().equals(ol.getBarcode())).findFirst();
        if (existingProduct.isPresent()) {
            orderTable.getItems().remove(existingProduct.get());
            ol.changeQuantity(ol.getQuantity() + existingProduct.get().getQuantity());
            currentOrder.removeOrderLine(existingProduct.get());
        }
        currentOrder.addOrderLine(ol);
        orderTable.getItems().add(ol);
    }
}
