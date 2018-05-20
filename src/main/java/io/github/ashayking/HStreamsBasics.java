package io.github.ashayking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.github.ashayking.model.Trade;
import io.github.ashayking.util.TradeUtil;

/**
 * 
 * @author Ashay S Patil
 *
 */
public class HStreamsBasics {

	public static void main(String[] args) {
		List<Trade> trades = TradeUtil.createTrades();
		// Find Trade Which has greater 10000 quantity and status is CANCEL and
		// Instrument is GOOG

		// OLD way
		List<Trade> resultOldWay = new ArrayList<>();
		for (Trade trade : trades) {
			if (trade.getQuantity() > 10000 && trade.getStatus().equals("CANCEL")
					&& trade.getInstrument().equals("GOOG")) {
				resultOldWay.add(trade);
			}
		}
		System.out.println(resultOldWay.size());
		
		// Streams to rescue
		List<Trade> resultNewWay = trades.stream()
								.filter(trade->trade.getQuantity()>10000)
								.filter(trade->trade.getStatus().equals("CANCEL"))
								.filter(trade->trade.getInstrument().equals("GOOG"))
								.collect(Collectors.toList());
		System.out.println(resultNewWay.size());
	}
}
