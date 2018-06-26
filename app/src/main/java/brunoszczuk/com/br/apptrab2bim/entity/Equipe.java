package brunoszczuk.com.br.apptrab2bim.entity;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

public class Equipe extends SugarRecord {
    @Unique
    private int cdEquipe;
    private String brEquipe;
    private String corEquipe;
    private String nmEquipe;
    private String nmComum;
    private String nmSlug;
    private String sgEquipe;
    private String tgEquipe;
    private String tpEquipe;
    private String uriEquipe;

    public int getCdEquipe() {
        return cdEquipe;
    }

    public void setCdEquipe(int cdEquipe) {
        this.cdEquipe = cdEquipe;
    }

    public String getBrEquipe() {
        return brEquipe;
    }

    public void setBrEquipe(String brEquipe) {
        this.brEquipe = brEquipe;
    }

    public String getCorEquipe() {
        return corEquipe;
    }

    public void setCorEquipe(String corEquipe) {
        this.corEquipe = corEquipe;
    }

    public String getNmEquipe() {
        return nmEquipe;
    }

    public void setNmEquipe(String nmEquipe) {
        this.nmEquipe = nmEquipe;
    }

    public String getNmComum() {
        return nmComum;
    }

    public void setNmComum(String nmComum) {
        this.nmComum = nmComum;
    }

    public String getNmSlug() {
        return nmSlug;
    }

    public void setNmSlug(String nmSlug) {
        this.nmSlug = nmSlug;
    }

    public String getSgEquipe() {
        return sgEquipe;
    }

    public void setSgEquipe(String sgEquipe) {
        this.sgEquipe = sgEquipe;
    }

    public String getTgEquipe() {
        return tgEquipe;
    }

    public void setTgEquipe(String tgEquipe) {
        this.tgEquipe = tgEquipe;
    }

    public String getTpEquipe() {
        return tpEquipe;
    }

    public void setTpEquipe(String tpEquipe) {
        this.tpEquipe = tpEquipe;
    }

    public String getUriEquipe() {
        return uriEquipe;
    }

    public void setUriEquipe(String uriEquipe) {
        this.uriEquipe = uriEquipe;
    }
}
