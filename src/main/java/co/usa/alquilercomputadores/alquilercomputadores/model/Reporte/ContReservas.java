package co.usa.alquilercomputadores.alquilercomputadores.model.Reporte;

import co.usa.alquilercomputadores.alquilercomputadores.model.Client;

public class ContReservas {
    
    private long total;
    private Client client;
    public ContReservas(long total, Client client) {
        this.total = total;
        this.client = client;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

}
