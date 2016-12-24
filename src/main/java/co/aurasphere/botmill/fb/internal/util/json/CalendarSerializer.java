package co.aurasphere.botmill.fb.internal.util.json;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.Calendar;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


/**
 * Class that handles the serialization of a Calendar using the Facebook date
 * format (YYYY-MM-DDThh:mm).
 * 
 * @author Donato Rimenti
 * @date Dec 18, 2016
 */
public class CalendarSerializer implements JsonSerializer<Calendar> {

	/**
	 * The formatter for the calendar.
	 */
	private final DecimalFormat formatter;

	/**
	 * Instantiates a new calendar serializer.
	 */
	public CalendarSerializer() {
		this.formatter = new DecimalFormat("00");
	}

	/**
	 * Serializes a Calendar using the Facebook date format
	 * (YYYY-MM-DDThh:mm).
	 *
	 * @param src the src
	 * @param typeOfSrc the type of src
	 * @param context the context
	 * @return the json element
	 */
	public JsonElement serialize(Calendar src, Type typeOfSrc,
			JsonSerializationContext context) {
		int year = src.get(Calendar.YEAR);
		String month = this.formatter.format(Double.valueOf(src
				.get(Calendar.MONTH) + 1));
		String day = this.formatter.format(Double.valueOf(src
				.get(Calendar.DAY_OF_MONTH)));
		String hour = this.formatter.format(Double.valueOf(src
				.get(Calendar.HOUR_OF_DAY)));
		String minute = this.formatter.format(Double.valueOf(src
				.get(Calendar.MINUTE)));
		String formattedDate = year + "-" + month + "-" + day + "T" + hour
				+ ":" + minute;

		return context.serialize(formattedDate);
	}
}
