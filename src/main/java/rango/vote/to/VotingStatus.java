package rango.vote.to;

import java.util.Date;

import rango.vote.model.Membro;

public class VotingStatus {

	private Membro membro;
	private boolean votingOpen;
	private Date dia;

	public Membro getMembro(){
		return membro;
	}

	public void setMembro(Membro membro){
		this.membro=membro;
	}

	public boolean isVotingOpen() {
		return votingOpen;
	}

	public void setVotingOpen(boolean votingOpen) {
		this.votingOpen = votingOpen;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

}
