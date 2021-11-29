package ru.job4j.cinema.store;

import ru.job4j.cinema.model.Account;
import ru.job4j.cinema.model.Place;
import ru.job4j.cinema.model.Ticket;

import java.sql.SQLException;
import java.util.Collection;

public interface Store {
    Collection<Place> findAllPlace();

    void reservePlace(int placeId);

    Ticket createTicket(Ticket ticket) throws SQLException;

    Ticket getTicketByRowAndCell(int row, int cell);

    Account createAccount(Account account);

    Account findAccountByPhone(String email);
}
