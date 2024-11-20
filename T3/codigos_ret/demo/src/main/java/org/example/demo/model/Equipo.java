package org.example.demo.model;

import java.io.Serializable;

public class Equipo implements Serializable {
    private String intRank, strTeam, strBadge,strForm, intPlayed, intWin, intLoss, intDraw;

    public Equipo() {
    }

    public Equipo(String intRank, String strTeam, String strBadge, String strForm, String intPlayed, String intWin, String intLoss, String intDraw) {
        this.intRank = intRank;
        this.strTeam = strTeam;
        this.strBadge = strBadge;
        this.strForm = strForm;
        this.intPlayed = intPlayed;
        this.intWin = intWin;
        this.intLoss = intLoss;
        this.intDraw = intDraw;
    }

    public String getIntRank() {
        return intRank;
    }

    public void setIntRank(String intRank) {
        this.intRank = intRank;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public String getStrForm() {
        return strForm;
    }

    public void setStrForm(String strForm) {
        this.strForm = strForm;
    }

    public String getIntPlayed() {
        return intPlayed;
    }

    public void setIntPlayed(String intPlayed) {
        this.intPlayed = intPlayed;
    }

    public String getIntWin() {
        return intWin;
    }

    public void setIntWin(String intWin) {
        this.intWin = intWin;
    }

    public String getIntLoss() {
        return intLoss;
    }

    public void setIntLoss(String intLoss) {
        this.intLoss = intLoss;
    }

    public String getIntDraw() {
        return intDraw;
    }

    public void setIntDraw(String intDraw) {
        this.intDraw = intDraw;
    }
}
