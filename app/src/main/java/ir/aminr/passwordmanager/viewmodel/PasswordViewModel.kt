package ir.aminr.passwordmanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.aminr.passwordmanager.model.Password
import ir.aminr.passwordmanager.repository.PasswordRepository
import ir.aminr.passwordmanager.util.PasswordGenerator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

class PasswordViewModel
@Inject constructor(
    private val passwordRepository: PasswordRepository,
    private val passwordGenerator: PasswordGenerator
) : ViewModel() {

    private val _passwordsState =
        MutableStateFlow<PasswordsState>(PasswordsState.Success(emptyList()))
    val passwordsState: StateFlow<PasswordsState> = _passwordsState

    private val _passwordState = MutableStateFlow<PasswordState>(PasswordState.Empty)
    val passwordState: StateFlow<PasswordState> = _passwordState

    private val _updatePasswordState =
        MutableStateFlow<UpdatePasswordState>(UpdatePasswordState.Empty)
    val updatePasswordState: StateFlow<UpdatePasswordState> = _updatePasswordState

    private val _deletePasswordState =
        MutableStateFlow<DeletePasswordState>(DeletePasswordState.Empty)
    val deletePasswordState: StateFlow<DeletePasswordState> = _deletePasswordState

    private val _insertPasswordState =
        MutableStateFlow<InsertPasswordState>(InsertPasswordState.Empty)
    val insertPasswordState: StateFlow<InsertPasswordState> = _insertPasswordState

    private val _createRandomPasswordState =
        MutableStateFlow<CreateRandomPasswordState>(CreateRandomPasswordState.Empty)
    val createRandomPasswordState: StateFlow<CreateRandomPasswordState> = _createRandomPasswordState

    private val userID: Long = 1

    init {
        viewModelScope.launch {
            _passwordsState.value = PasswordsState.Loading
            try {
                val passwords = passwordRepository.getPasswords(userID)
                _passwordsState.value = PasswordsState.Success(passwords)
            } catch (e: Exception) {
                _passwordsState.value = PasswordsState.Error(e)
            }
        }
    }

    fun getPassword(passwordID: Long) {
        viewModelScope.launch {
            _passwordState.value = PasswordState.Loading
            try {
                val password = passwordRepository.getPassword(passwordID)
                _passwordState.value = PasswordState.Success(password)
            } catch (e: Exception) {
                _passwordState.value = PasswordState.Error(e)
            }
        }
    }

    fun updatePassword(password: Password) {
        viewModelScope.launch {
            _updatePasswordState.value = UpdatePasswordState.Loading
            try {
                passwordRepository.updatePassword(password)
                _updatePasswordState.value = UpdatePasswordState.Success
            } catch (e: Exception) {
                _updatePasswordState.value = UpdatePasswordState.Error(e)
            }
            _updatePasswordState.value = UpdatePasswordState.Empty
        }
    }

    fun insertPassword(password: Password) {
        viewModelScope.launch {
            _insertPasswordState.value = InsertPasswordState.Loading
            try {
                passwordRepository.insertPassword(password)
                _insertPasswordState.value = InsertPasswordState.Success(password)
            } catch (e: Exception) {
                _insertPasswordState.value = InsertPasswordState.Error(e)
            }
            _insertPasswordState.value = InsertPasswordState.Empty
        }
    }

    fun deletePassword(password: Password) {
        viewModelScope.launch {
            _deletePasswordState.value = DeletePasswordState.Loading
            try {
                passwordRepository.deletePassword(password)
                _deletePasswordState.value = DeletePasswordState.Success
            } catch (e: Exception) {
                _deletePasswordState.value = DeletePasswordState.Error(e)
            }
            _deletePasswordState.value = DeletePasswordState.Empty
        }
    }

    fun createRandomPassword(
        length: Int,
        generator: PasswordGenerator.Generator
    ) {
        viewModelScope.launch {
            _createRandomPasswordState.value = CreateRandomPasswordState.Loading
            _createRandomPasswordState.value =
                CreateRandomPasswordState.Success(passwordGenerator.getPassword(length, generator))
            _createRandomPasswordState.value = CreateRandomPasswordState.Empty
        }
    }

    sealed class PasswordsState {
        data class Success(val passwords: List<Password>) : PasswordsState()
        data class Error(val exception: Throwable) : PasswordsState()
        object Loading : PasswordsState()
    }

    sealed class PasswordState {
        data class Success(val password: Password) : PasswordState()
        data class Error(val exception: Throwable) : PasswordState()
        object Loading : PasswordState()
        object Empty : PasswordState()
    }

    sealed class InsertPasswordState {
        data class Success(val password: Password) : InsertPasswordState()
        data class Error(val exception: Throwable) : InsertPasswordState()
        object Loading : InsertPasswordState()
        object Empty : InsertPasswordState()
    }

    sealed class UpdatePasswordState {
        object Success : UpdatePasswordState()
        data class Error(val exception: Throwable) : UpdatePasswordState()
        object Loading : UpdatePasswordState()
        object Empty : UpdatePasswordState()
    }

    sealed class DeletePasswordState {
        object Success : DeletePasswordState()
        data class Error(val exception: Throwable) : DeletePasswordState()
        object Loading : DeletePasswordState()
        object Empty : DeletePasswordState()
    }

    sealed class CreateRandomPasswordState {
        data class Success(val passwords: String) : CreateRandomPasswordState()
        object Loading : CreateRandomPasswordState()
        object Empty : CreateRandomPasswordState()
    }
}