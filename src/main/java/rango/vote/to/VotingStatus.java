package rango.vote.to;

import java.util.Date;

import rango.vote.model.Membro;

import lombok.Data;

@Data
public class VotingStatus {

	private Membro membro;
	private boolean votingOpen;
	private Date dia;

}
