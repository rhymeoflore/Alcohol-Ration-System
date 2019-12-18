package in.inzenjer.sentliquor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import in.inzenjer.getNames.GetNamesByID;

public class ProcessingRequest {
	
	public static void ProcessingDataRequestObject( HttpServletRequest req) throws SQLException{
		ArrayList<HashMap<String, Integer>> beerlist,rumlist,whiskylist,brandylist;
		String outletID=req.getParameter("oid");
		String beerID[]=req.getParameterValues("beer_brid");
		String rumID[]=req.getParameterValues("rum_brid");
		String whiskyID[]=req.getParameterValues("whi_brid");
		String brandyID[]=req.getParameterValues("bnd_brid");
		beerlist=getBeermapList(beerID,req);
		rumlist=getRumMapList(rumID,req);
		whiskylist=getWhiskyMapList(whiskyID,req);
		brandylist=getBrandyMapList(brandyID,req);
		RecordSendLiquor.recordBeerData(outletID,"1",beerID,beerlist);
		RecordSendLiquor.recordRumData(outletID,"2",rumID,rumlist);
		RecordSendLIquor2.recordWhiskyData(outletID,"3",whiskyID,whiskylist);
		RecordSendLiquor3.recordBrandyData(outletID,"4",brandyID,brandylist);
		
	}

	private static ArrayList<HashMap<String, Integer>> getBrandyMapList(String[] brandyID, HttpServletRequest req) {
		// TODO Auto-generated method stub
		ArrayList<HashMap<String, Integer>> brandy=new ArrayList<HashMap<String, Integer>>();
		HashMap<String,Integer> bnd750map=new HashMap<String,Integer>();
		HashMap<String,Integer> bnd375map=new HashMap<String,Integer>();
		HashMap<String,Integer> bnd180map=new HashMap<String,Integer>();
		for(int i=0;i<brandyID.length;i++){
			String m=null;
			m=req.getParameter("3_"+brandyID[i]+"_750bot");
			if((m!=null)&&(m.length()>0)){
				bnd750map.put(brandyID[i], Integer.parseInt(req.getParameter("4_"+brandyID[i]+"_750bot")));
			}
			String n=null;
			n=req.getParameter("3_"+brandyID[i]+"_375bot");
			if((n!=null)&&(n.length()>0)){
				bnd375map.put(brandyID[i], Integer.parseInt(req.getParameter("4_"+brandyID[i]+"_375bot")));
			}
			String o=null;
			o=req.getParameter("3_"+brandyID[i]+"_180bot");
			if((o!=null)&&(o.length()>0)){
				bnd180map.put(brandyID[i], Integer.parseInt(req.getParameter("4_"+brandyID[i]+"_180bot")));
			}
			
		}

		System.out.println("brandyyyyyy\n");
		for(int i=0;i<brandyID.length;i++){
			System.out.println(GetNamesByID.getBrandyNameByID(brandyID[i])+"\n");
			System.out.println("750="+bnd750map.get(brandyID[i])+"\n");
			System.out.println("375="+bnd375map.get(brandyID[i])+"\n");
			System.out.println("180="+bnd180map.get(brandyID[i])+"\n");
		}
		brandy.add(bnd750map);
		brandy.add(bnd375map);
		brandy.add(bnd180map);
		return brandy;
		
	}

	private static ArrayList<HashMap<String, Integer>> getWhiskyMapList(String[] whiskyID, HttpServletRequest req) {
		// TODO Auto-generated method stub
		ArrayList<HashMap<String, Integer>> whisky=new ArrayList<HashMap<String, Integer>>();
		HashMap<String,Integer> whi750map=new HashMap<String,Integer>();
		HashMap<String,Integer> whi375map=new HashMap<String,Integer>();
		HashMap<String,Integer> whi180map=new HashMap<String,Integer>();
		for(int i=0;i<whiskyID.length;i++){
			System.out.println("whisky length="+whiskyID.length);
			System.out.println("IDDDDDD="+req.getParameter("3_"+whiskyID[i]+"_750bot"));
			String m=null;
			m=req.getParameter("3_"+whiskyID[i]+"_750bot");
			if((m!=null)&&(m.length()>0)){
				whi750map.put(whiskyID[i], Integer.parseInt(req.getParameter("3_"+whiskyID[i]+"_750bot")));
			}
			String n=null;
			n=req.getParameter("3_"+whiskyID[i]+"_375bot");
			if((n!=null)&&(n.length()>0)){
				whi375map.put(whiskyID[i], Integer.parseInt(req.getParameter("3_"+whiskyID[i]+"_375bot")));
			}
			String o=null;
			o=req.getParameter("3_"+whiskyID[i]+"_180bot");
			if((o!=null)&&(o.length()>0)){
				whi180map.put(whiskyID[i], Integer.parseInt(req.getParameter("3_"+whiskyID[i]+"_180bot")));
			}
			
		}

		System.out.println("whiskyyyy\n");
		for(int i=0;i<whiskyID.length;i++){
			System.out.println(GetNamesByID.getWhiskyNameByID(whiskyID[i])+"\n");
			System.out.println("750="+whi750map.get(whiskyID[i])+"\n");
			System.out.println("375="+whi375map.get(whiskyID[i])+"\n");
			System.out.println("180="+whi180map.get(whiskyID[i])+"\n");
		}
		whisky.add(whi750map);
		whisky.add(whi375map);
		whisky.add(whi180map);
		return whisky;
	}

	private static ArrayList<HashMap<String, Integer>> getRumMapList(String[] rumID, HttpServletRequest req) {
		// TODO Auto-gene;rated method stub
		ArrayList<HashMap<String, Integer>> rum=new ArrayList<HashMap<String, Integer>>();
		HashMap<String,Integer> rum750map=new HashMap<String,Integer>();
		HashMap<String,Integer> rum375map=new HashMap<String,Integer>();
		HashMap<String,Integer> rum180map=new HashMap<String,Integer>();
		for(int i=0;i<rumID.length;i++){
			String n=null;
			n=req.getParameter("2_"+rumID[i]+"_750bot");
			if((n!=null)&&(n.length()>0)){
				rum750map.put(rumID[i], Integer.parseInt(req.getParameter("2_"+rumID[i]+"_750bot")));
			}
			String m=null;
			m=req.getParameter("2_"+rumID[i]+"_375bot");
			if((m!=null)&&(m.length()>0)){
				rum375map.put(rumID[i], Integer.parseInt(req.getParameter("2_"+rumID[i]+"_375bot")));
			}
			String o=null;
			o=req.getParameter("2_"+rumID[i]+"_180bot");
			if((o!=null)&&(o.length()>0)){
				rum180map.put(rumID[i], Integer.parseInt(req.getParameter("2_"+rumID[i]+"_180bot")));
			}
		
			
		}

		System.out.println("rummmmm");
		for(int i=0;i<rumID.length;i++){
			System.out.println(GetNamesByID.getRumNameByID(rumID[i])+"\n");
			System.out.println("750="+rum750map.get(rumID[i])+"\n");
			System.out.println("375="+rum375map.get(rumID[i])+"\n");
			System.out.println("180="+rum180map.get(rumID[i])+"\n");
		}
		rum.add(rum750map);
		rum.add(rum375map);
		rum.add(rum180map);
		return rum;
		
	}

	private static ArrayList<HashMap<String, Integer>> getBeermapList(String[] beerID, HttpServletRequest req) {
		// TODO Auto-generated method stub
		ArrayList<HashMap<String, Integer>> beer=new ArrayList<HashMap<String, Integer>>();
		HashMap<String,Integer> beermap=new HashMap<String,Integer>();
		for(int i=0;i<beerID.length;i++){
			String n=null;
			n=req.getParameter("1_"+beerID[i]+"_bot").trim();
			System.out.println("n==="+n+"p");
			if((n!=null)&&(n.length()>0)){
				System.out.println("data exists="+n);
				System.out.println("1_"+beerID[i]+"_bot");
				beermap.put(beerID[i],Integer.parseInt(req.getParameter("1_"+beerID[i]+"_bot")) );
			}
			
			
		}
		
		System.out.println("Beerrrr\n");
		for(int i=0;i<beerID.length;i++){
			System.out.println(GetNamesByID.getBrandNameByID(beerID[i])+"="+beermap.get(beerID[i])+"\n");
		}
		beer.add(beermap);
		return beer;
	}

}
