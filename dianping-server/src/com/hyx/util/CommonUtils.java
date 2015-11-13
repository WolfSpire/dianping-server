package com.hyx.util;

public class CommonUtils {
	/**
	 * 
	 * @param lat
	 * @param lon
	 * @param raidus
	 *            �뾶
	 * @return ���С�ľ�ά��
	 */
	// SELECT p . * , s . *
	// FROM prodouct p, shop s
	// WHERE p.shop_id = s.shop_id
	// AND s.shop_lon > 19.22931121943896ands.shop_lon <
	// 119.23973478056104ands.shop_lat > 30.45220738013896ands.shop_lat <
	// 120.46119261986104
	// LIMIT 0 , 30
	// //http://localhost:8080/ls_server/servlet/NearbyServlet?lat=19.22931121943896&lon=119.234523&raidus=1000
	public static double[] getAroud(double lat, double lon, double raidus) {
		// ������ܳ��� 24901����
		// Ӣ�� ���׵Ļ��� ��λ�� 1609 ��
		// ά�ȡ���������������������������������������������������������������������
		// 1���������һ��ÿһ��ռ������
		double degree = (24901 * 1609) / 360.0;
		// ����ά���ϱ仯һ�׶��ٶ�
		double dpmLat = 1 / degree;
		// ���������뾶��ά�ȵĶ���
		double raidusLat = dpmLat * raidus;
		double minLat = lat - raidusLat;
		double maxLat = lat + raidusLat;

		// ���ȡ���������������������������������������������������������������������
		// ���Ƕ�λ�ĵص��СȦ�ϵľ���仯
		double mpdLng = degree * Math.cos(lat * (Math.PI / 180));
		double dpmLng = 1 / mpdLng;
		double raidusLng = dpmLng * raidus;
		double minLng = lon - raidusLng;
		double maxLng = lon + raidusLng;
		return new double[] { minLat, minLng, maxLat, maxLng };
	}

}
