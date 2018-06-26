package brunoszczuk.com.br.apptrab2bim.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Unique;

public class Classificacao extends SugarRecord{

    @SerializedName("cdEquipe")
    @Expose
    @Unique
    private String cdEquipe;
    @SerializedName("golsPro")
    @Expose
    private Integer golsPro;
    @SerializedName("golsContra")
    @Expose
    private Integer golsContra;
    @SerializedName("saldoGols")
    @Expose
    private Integer saldoGols;
    @SerializedName("pos")
    @Expose
    private String pos;
    @SerializedName("ganhoPos")
    @Expose
    private String ganhoPos;
    @SerializedName("pontosGanhos")
    @Expose
    private PontosGanhos pontosGanhos;
    @SerializedName("jogos")
    @Expose
    private Jogos jogos;
    @SerializedName("vitoria")
    @Expose
    private Vitoria vitoria;
    @SerializedName("empate")
    @Expose
    private Empate empate;
    @SerializedName("derrota")
    @Expose
    private Derrota derrota;
    @SerializedName("aproveitamento")
    @Expose
    private Double aproveitamento;

    public String getCdEquipe() {
        return cdEquipe;
    }

    public void setCdEquipe(String cdEquipe) {
        this.cdEquipe = cdEquipe;
    }

    public Integer getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(Integer golsPro) {
        this.golsPro = golsPro;
    }

    public Integer getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(Integer golsContra) {
        this.golsContra = golsContra;
    }

    public Integer getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(Integer saldoGols) {
        this.saldoGols = saldoGols;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getGanhoPos() {
        return ganhoPos;
    }

    public void setGanhoPos(String ganhoPos) {
        this.ganhoPos = ganhoPos;
    }

    public PontosGanhos getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(PontosGanhos pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public Jogos getJogos() {
        return jogos;
    }

    public void setJogos(Jogos jogos) {
        this.jogos = jogos;
    }

    public Vitoria getVitoria() {
        return vitoria;
    }

    public void setVitoria(Vitoria vitoria) {
        this.vitoria = vitoria;
    }

    public Empate getEmpate() {
        return empate;
    }

    public void setEmpate(Empate empate) {
        this.empate = empate;
    }

    public Derrota getDerrota() {
        return derrota;
    }

    public void setDerrota(Derrota derrota) {
        this.derrota = derrota;
    }

    public Double getAproveitamento() {
        return aproveitamento;
    }

    public void setAproveitamento(Double aproveitamento) {
        this.aproveitamento = aproveitamento;
    }

    public class Derrota {

        @SerializedName("qtMandante")
        @Expose
        private Integer qtMandante;
        @SerializedName("qtTotal")
        @Expose
        private Integer qtTotal;
        @SerializedName("qtVisitante")
        @Expose
        private Integer qtVisitante;

        public Integer getQtMandante() {
            return qtMandante;
        }

        public void setQtMandante(Integer qtMandante) {
            this.qtMandante = qtMandante;
        }

        public Integer getQtTotal() {
            return qtTotal;
        }

        public void setQtTotal(Integer qtTotal) {
            this.qtTotal = qtTotal;
        }

        public Integer getQtVisitante() {
            return qtVisitante;
        }

        public void setQtVisitante(Integer qtVisitante) {
            this.qtVisitante = qtVisitante;
        }

    }

    ;

    public class Empate {

        @SerializedName("qtMandante")
        @Expose
        private Integer qtMandante;
        @SerializedName("qtTotal")
        @Expose
        private Integer qtTotal;
        @SerializedName("qtVisitante")
        @Expose
        private Integer qtVisitante;

        public Integer getQtMandante() {
            return qtMandante;
        }

        public void setQtMandante(Integer qtMandante) {
            this.qtMandante = qtMandante;
        }

        public Integer getQtTotal() {
            return qtTotal;
        }

        public void setQtTotal(Integer qtTotal) {
            this.qtTotal = qtTotal;
        }

        public Integer getQtVisitante() {
            return qtVisitante;
        }

        public void setQtVisitante(Integer qtVisitante) {
            this.qtVisitante = qtVisitante;
        }
    }

    public class Jogos {

        @SerializedName("qtMandante")
        @Expose
        private Integer qtMandante;
        @SerializedName("qtTotal")
        @Expose
        private Integer qtTotal;
        @SerializedName("qtVisitante")
        @Expose
        private Integer qtVisitante;

        public Integer getQtMandante() {
            return qtMandante;
        }

        public void setQtMandante(Integer qtMandante) {
            this.qtMandante = qtMandante;
        }

        public Integer getQtTotal() {
            return qtTotal;
        }

        public void setQtTotal(Integer qtTotal) {
            this.qtTotal = qtTotal;
        }

        public Integer getQtVisitante() {
            return qtVisitante;
        }

        public void setQtVisitante(Integer qtVisitante) {
            this.qtVisitante = qtVisitante;
        }
    }

    public class PontosGanhos {

        @SerializedName("qtMandante")
        @Expose
        private Integer qtMandante;
        @SerializedName("qtTotal")
        @Expose
        private Integer qtTotal;
        @SerializedName("qtVisitante")
        @Expose
        private Integer qtVisitante;

        public Integer getQtMandante() {
            return qtMandante;
        }

        public void setQtMandante(Integer qtMandante) {
            this.qtMandante = qtMandante;
        }

        public Integer getQtTotal() {
            return qtTotal;
        }

        public void setQtTotal(Integer qtTotal) {
            this.qtTotal = qtTotal;
        }

        public Integer getQtVisitante() {
            return qtVisitante;
        }

        public void setQtVisitante(Integer qtVisitante) {
            this.qtVisitante = qtVisitante;
        }

    }

    public class Vitoria {

        @SerializedName("qtMandante")
        @Expose
        private Integer qtMandante;
        @SerializedName("qtTotal")
        @Expose
        private Integer qtTotal;
        @SerializedName("qtVisitante")
        @Expose
        private Integer qtVisitante;

        public Integer getQtMandante() {
            return qtMandante;
        }

        public void setQtMandante(Integer qtMandante) {
            this.qtMandante = qtMandante;
        }

        public Integer getQtTotal() {
            return qtTotal;
        }

        public void setQtTotal(Integer qtTotal) {
            this.qtTotal = qtTotal;
        }

        public Integer getQtVisitante() {
            return qtVisitante;
        }

        public void setQtVisitante(Integer qtVisitante) {
            this.qtVisitante = qtVisitante;
        }

    }
}