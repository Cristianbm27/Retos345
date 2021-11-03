package co.usa.alquilercomputadores.alquilercomputadores.model.Reporte;

public class ContStatusReservas {
    private int completed;
    private int cancelled;
    public ContStatusReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
    public int getCompleted() {
        return completed;
    }
    public void setCompleted(int completed) {
        this.completed = completed;
    }
    public int getCancelled() {
        return cancelled;
    }
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    
    
}
