package pl.motyka.mateusz.klaser.services;

import java.util.List;

import pl.motyka.mateusz.klaser.services.NotificationServiceImpl.NotificationMessage;

public interface NotificationService {
	void addInfoMessage(String msg);

	void addErrorMessage(String msg);

	List<NotificationMessage> getNotificationMessages();
}