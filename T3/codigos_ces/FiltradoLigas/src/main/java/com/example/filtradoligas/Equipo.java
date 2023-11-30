package com.example.filtradoligas;

public class Equipo {

    public String strTeam,strLeague,strDescriptionEN,strTeamBadge;

    public Equipo(String strTeam, String strLeague, String strDescriptionEN, String strTeamBadge) {
        this.strTeam = strTeam;
        this.strLeague = strLeague;
        this.strDescriptionEN = strDescriptionEN;
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    @Override
    public String toString() {
        return strTeam;
    }
}
