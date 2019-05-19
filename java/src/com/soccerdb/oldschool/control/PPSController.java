package com.soccerdb.oldschool.control;

import java.util.Iterator;
import java.util.List;

import com.soccerdb.oldschool.db.dao.ImplPPSDAO;
import com.soccerdb.oldschool.db.dao.ImplPlayerDAO;
import com.soccerdb.oldschool.db.dao.ImplSeasonDAO;
import com.soccerdb.oldschool.db.dao.PPSDAO;
import com.soccerdb.oldschool.db.dao.PlayerDAO;
import com.soccerdb.oldschool.db.dao.SeasonDAO;
import com.soccerdb.oldschool.db.entity.Player;
import com.soccerdb.oldschool.db.entity.Player_per_Season;
import com.soccerdb.oldschool.db.entity.Season;

public class PPSController implements ControllerInterface<Player_per_Season>{

	private static PPSController controller;
	
	static {
		try {
			if(controller == null) {
				controller = new PPSController();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//PlayerController c_player;
	//SeasonController c_season;
	
	Player_per_Season pps;
	Player player;
	Season season;
	PlayerDAO playerDAO = new ImplPlayerDAO();
	SeasonDAO seasonDAO = new ImplSeasonDAO();
	PPSDAO ppsDAO = new ImplPPSDAO();
	List<Player_per_Season> ppsList;
	Iterator<Player_per_Season> itr;
	int count;
	String temp = "";
	String more_condition;
	String column_name = "Name\t" + "Season\t" + "Position\t" +"Height\t" + "Weight\t" + "Goals\t" + "Assists\t" + "Saves\t" + "Game\t" + "Card\t" + "Foul" + "\n"
						+"----\t-----\t------\t-----\t----\t----\t-----\t----\t----\t----\t----\t" +"\n";
	
	String range_condition;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		temp = column_name;
		range_condition = "";
		//if(c_player == null) c_player = PlayerController.getController();
		//if(c_season == null) c_season = SeasonController.getController();
	}

	@Override
	public String selectAll() {
		init();
		try {
			System.out.println("selectAll");
			ppsList = ppsDAO.selectAll();
			getData();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public String search(String attribute, String condition) {
		init();
		if(!attribute.isEmpty() && !condition.isEmpty()) {
			try {
				commaChecker(condition);
				// TODO Between Queries!
				switch(attribute) {
					case "position":
						pps.setPps_position(condition);
						ppsList = ppsDAO.searchPPSWhosePositionIs(pps);
						break;
					case "height":
						pps.setPps_height(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseHeightIs(pps);
						break;
					case "heigth shorter":
						pps.setPps_height(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseShorterThan(pps);
						break;
					case "height taller":
						pps.setPps_height(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseTallerThan(pps);
						break;
					case "weight":
						pps.setPps_weight(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseWeightIs(pps);
						break;
					case "weight lighter":
						pps.setPps_weight(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseLighterThan(pps);
						break;
					case "weight heavier":
						pps.setPps_weight(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseHeightIs(pps);
						break;
					case "goal":
						pps.setPps_season_goal(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseGoalsAre(pps);
						break;
					case "goal less":
						pps.setPps_season_goal(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseGoalsLessThan(pps);
						break;
					case "goal more":
						pps.setPps_season_goal(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseGoalsMoreThan(pps);
						break;
					case "assist":
						pps.setPps_season_assist(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseAssistsAre(pps);
						break;
					case "assist less":
						pps.setPps_season_assist(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseAssistsLessThan(pps);
						break;
					case "assist more":
						pps.setPps_season_assist(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseAssistsMoreThan(pps);
						break;
					case "save":
						pps.setPps_season_save(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseSavesAre(pps);
						break;
					case "save less":
						pps.setPps_season_save(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseSavesLessThan(pps);
						break;
					case "save more":
						pps.setPps_season_save(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseSavesMoreThan(pps);
						break;
					case "game":
						pps.setPps_season_game(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseGamesAre(pps);
						break;
					case "game less":
						pps.setPps_season_game(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseGamesLessThan(pps);
						break;
					case "game more":
						pps.setPps_season_game(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseGamesMoreThan(pps);
						break;
					case "card":
						pps.setPps_season_card(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseCardsAre(pps);
						break;
					case "card less":
						pps.setPps_season_card(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseCardsLessThan(pps);
						break;
					case "card more":
						pps.setPps_season_card(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseCardsMoreThan(pps);
						break;
					case "foul":
						pps.setPps_season_foul(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseFoulsAre(pps);
						break;
					case "foul less":
						pps.setPps_season_foul(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseFoulsLessThan(pps);
						break;
					case "foul more":
						pps.setPps_season_foul(Integer.parseInt(condition));
						ppsList = ppsDAO.searchPPSWhoseFoulsMoreThan(pps);
						break;
					default:
						temp += "\n\n\n\t\t\tIllegal Attribute... is it " + attribute +"?";	
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				getData();
			}
		}
		
		if(temp.equals(column_name)) temp += "\n\n\n\t\t\t There is no data for " + condition + " at " + attribute + "in Player Per Season Table"  + " \n";
		
		return temp;
	}

	@Override
	public String order(String attribute, String condition) {
		init();
		if(!attribute.isEmpty() && !condition.isEmpty()) {
			
			try {
				if(condition.equals("dsc")) {
					switch(attribute) {
					case "season":
						ppsList = ppsDAO.searchPPSOrderBySeasonDesc(pps);
						break;
					case "position":
						ppsList = ppsDAO.searchPPSOrderByPositionDesc(pps);
						break;
					case "height":
						ppsList = ppsDAO.searchPPSOrderByHeightDesc(pps);
						break;
					case "weight":
						ppsList = ppsDAO.searchPPSOrderByWeightDesc(pps);
						break;
					case "goal":
						ppsList = ppsDAO.searchPPSOrderByGoalsDesc(pps);
						break;
					case "assist":
						ppsList = ppsDAO.searchPPSOrderByAssistsDesc(pps);
						break;
					case "save":
						ppsList = ppsDAO.searchPPSOrderBySavesDesc(pps);
						break;
					case "game":
						ppsList = ppsDAO.searchPPSOrderByGamesDesc(pps);
						break;
					case "card":
						ppsList = ppsDAO.searchPPSOrderByCardsDesc(pps);
						break;
					case "foul":
						ppsList = ppsDAO.searchPPSOrderByFoulsDesc(pps);
						break;
					default:
						temp += "\n\n\n\t\t\tIllegal Attribute... is it " + attribute +"?";
					}
				}else {
					switch(attribute) {
					case "season":
						ppsList = ppsDAO.searchPPSOrderBySeason(pps);
						break;
					case "position":
						ppsList = ppsDAO.searchPPSOrderByPosition(pps);
						break;
					case "height":
						ppsList = ppsDAO.searchPPSOrderByHeight(pps);
						break;
					case "weight":
						ppsList = ppsDAO.searchPPSOrderByWeight(pps);
						break;
					case "goal":
						ppsList = ppsDAO.searchPPSOrderByGoals(pps);
						break;
					case "assist":
						ppsList = ppsDAO.searchPPSOrderByAssists(pps);
						break;
					case "save":
						ppsList = ppsDAO.searchPPSOrderBySaves(pps);
						break;
					case "game":
						ppsList = ppsDAO.searchPPSOrderByGames(pps);
						break;
					case "card":
						ppsList = ppsDAO.searchPPSOrderByCards(pps);
						break;
					case "foul":
						ppsList = ppsDAO.searchPPSOrderByFouls(pps);
						break;
					default:
						temp += "\n\n\n\t\t\tIllegal Attribute... is it " + attribute +"?";
					}
				}
			}catch(Exception e) {
				
			}finally{
				getData();
			}
		}
		if(temp.equals(column_name)) temp += "\n\n\n\t\t\t There is no data for " + condition + " at " + attribute + "in Player Per Season Table"  + " \n";
		
		return temp;
	}

	@Override
	public int count(String attribute, String condition) {
		if(!attribute.isEmpty()) pps.setPlayer_id(Integer.parseInt(attribute));
		if(!condition.isEmpty()) pps.setSeason_id(Integer.parseInt(condition));
		try {
			count = ppsDAO.countAllPPS(pps);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int sum(String attribute, Player_per_Season _pps) {
		if(_pps.equals(null)) {
			count = -1;
		}else {
			try {
				switch(attribute) {
				case "goal":
					count = ppsDAO.sumOfPlayerGoals(_pps);
					break;
				case "assist":
					count = ppsDAO.sumOfPlayerAssists(_pps);
					break;
				case "save":
					count = ppsDAO.sumOfPlayerSaves(_pps);
					break;
				case "game":
					count = ppsDAO.sumOfPlayerGames(_pps);
					break;
				case "card":
					count = ppsDAO.sumOfPlayerCards(_pps);
					break;
				case "foul":
					count = ppsDAO.sumOfPlayerFouls(_pps);
					break;
				default:
					count = -1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	void getData(){
		try {
			itr = ppsList.iterator();
			while(itr.hasNext()) {
				pps = itr.next();
				player = playerDAO.selectById(pps.getPlayer_id());
				season = seasonDAO.selectById(pps.getSeason_id());
				temp += player.getPlayer_name() + "\t" + season.getSeason_year() + "\t" + pps.getPps_position() +"\t" + pps.getPps_height() + "\t" + pps.getPps_weight() + "\t" + pps.getPps_season_goal() + "\t" + pps.getPps_season_assist() + "\t" + pps.getPps_season_save() + "\t" + pps.getPps_season_game() + "\t" + pps.getPps_season_card() + "\t" +pps.getPps_season_foul() + "\n"; //c_player.search("id", ""+pps.getPlayer_id()) + "\t" + c_season.search("id", ""+pps.getSeason_id()) + "\t" + 
				//System.out.println(temp);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void commaChecker(String target) {
		int index_comma;
		if(target.contentEquals(",")) {
			index_comma = target.indexOf(',');
			range_condition = target.substring(index_comma+1, target.length());
			target = target.substring(0, index_comma-1);
		}
	}
	
	
	public static PPSController getController() {
		// TODO Auto-generated method stub
		return controller;
	}

}