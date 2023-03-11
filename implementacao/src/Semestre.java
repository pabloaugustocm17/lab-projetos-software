import java.util.Date;

public class Semestre {

    private Date dataInicio;
    private Date dataFim;
    private boolean aberto;
    private Universidade universidade;


    public Semestre(Date dataInicio, Date dataFim, Universidade universidade){
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.universidade = universidade;
        this.aberto = true;

    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public boolean getAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto){
        this.aberto = aberto;
    }

    public Universidade getUniversidade() {
        return universidade;
    }
}
