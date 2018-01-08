
package com.multimedia.modelo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

/**
 *
 * @author Grupo11
 */
public class FormateaFecha {

  public static Date comoDate(LocalDate localDate) {
    return (Date) Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
  }

  public static LocalDate comoLocalDate(Date date) {
    return (LocalDate)Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
  }
}
