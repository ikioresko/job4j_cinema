package ru.job4j.cinema.service;

import ru.job4j.cinema.model.Account;
import ru.job4j.cinema.model.Place;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.store.Store;

import java.sql.SQLException;
import java.util.Collection;

public class PsqlStoreService {
    private final Store store;

    public PsqlStoreService(Store store) {
        this.store = store;
    }

    public Collection<Place> findAllPlace() {
        return store.findAllPlace();
    }

    public void reservePlace(int placeId) {
        store.reservePlace(placeId);
    }

    public Ticket createTicket(Ticket ticket) throws SQLException {
        return store.createTicket(ticket);
    }

    public Ticket getTicketByRowAndCell(int row, int cell) {
        return store.getTicketByRowAndCell(row, cell);
    }

    public Account createAccount(Account account) {
        return store.createAccount(account);
    }

    public Account findAccountByPhone(String email) {
        return store.findAccountByPhone(email);
    }
}
